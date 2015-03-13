package com.lmiky.jdp.xmpp.client.connection;

import java.io.IOException;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.SmackException.NotConnectedException;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

import com.lmiky.jdp.util.PropertiesUtils;

/**
 * 连接工具
 * @author lmiky
 * @date 2015年3月13日 下午3:10:41
 */
public class ConnectionManager {
	public static final String SERVERNAME = PropertiesUtils.getStringContextValue("xmpp.servername");	//服务名
	public static final String HOST = PropertiesUtils.getStringContextValue("xmpp.host");							//域名
	public static final int PORT = PropertiesUtils.getIntContextValue("xmpp.port");										//端口
	
	private static XMPPConnection CONN = null;
	
	private static final Object LOCK_OBJ = new Object();	//加锁
	
	/**
	 * 初始化
	 * @author lmiky
	 * @date 2015年3月13日 下午3:21:33
	 * @throws SmackException
	 * @throws IOException
	 * @throws XMPPException
	 */
	private static void initConnection() throws SmackException, IOException, XMPPException {
		ConnectionConfiguration config = new ConnectionConfiguration(HOST, PORT, SERVERNAME);
        config.setCompressionEnabled(true);	//是否启用压缩
		//config.setReconnectionAllowed(false);  	// 允许自动连接  
		config.setSendPresence(false);//是否告诉服务器自己的状态:：如果需要处理离线消息，则不能告诉
		config.setSecurityMode(SecurityMode.disabled);	//否则会报DNS错误
        config.setDebuggerEnabled(false);	//是否启用调试
        Roster.setDefaultSubscriptionMode(Roster.SubscriptionMode.manual); //手工处理所有好友申请请求
		CONN = new XMPPTCPConnection(config);
		CONN.connect();
	}

	/**
	 * 获取XMPP连接
	 * @author lmiky
	 * @date 2015年3月13日 下午3:54:08
	 * @return
	 * @throws SmackException
	 * @throws IOException
	 * @throws XMPPException
	 */
	public static XMPPConnection getConnection() throws SmackException, IOException, XMPPException {
		synchronized(LOCK_OBJ) {
			if(CONN == null) {
				initConnection();
			}
			return CONN;
		}
	}
	
	/**
	 * 获取连接并登陆
	 * @author lmiky
	 * @date 2015年3月13日 下午4:35:21
	 * @param userName
	 * @param password
	 * @return
	 * @throws SmackException
	 * @throws IOException
	 * @throws XMPPException
	 */
	public static XMPPConnection getConnection(String userName, String password) throws SmackException, IOException, XMPPException {
		synchronized(LOCK_OBJ) {
			if(CONN == null) {	//未创建连接
				login(userName, password);
				return CONN;
			}
			if(!CONN.isAuthenticated()) {	//未登陆
				login(userName, password);
			} else {
				String currentLoginedUser = CONN.getUser().split("@")[0];	//当前连接登陆用户
				if(!currentLoginedUser.equals(userName)) {		//已有用户登陆且不是需要登陆的用户用户
					disconnect();	//断开连接
					login(userName, password);
				}
			}
			return CONN;
		}
	}
	
	/**
	 * 登陆
	 * @author lmiky
	 * @date 2015年3月13日 下午3:54:21
	 * @param userName
	 * @param password
	 * @throws SmackException
	 * @throws IOException
	 * @throws XMPPException
	 */
	public static void login(String userName, String password) throws SmackException, IOException, XMPPException {
		getConnection().login(userName, password);
	}
	
	/**
	 * 上线
	 * @author lmiky
	 * @date 2015年3月13日 下午3:57:29
	 * @throws NotConnectedException
	 */
	public static void online() throws NotConnectedException {
		Presence presence = new Presence(Presence.Type.available);  
		CONN.sendPacket(presence);
	}
	
	/**
	 * 下线
	 * @author lmiky
	 * @date 2015年3月13日 下午3:57:48
	 * @throws NotConnectedException
	 */
	public static void offline() throws NotConnectedException {
		Presence presence = new Presence(Presence.Type.unavailable);  
		CONN.sendPacket(presence);
	}
	
	/**
	 * 断开连接
	 * @author lmiky
	 * @date 2015年3月13日 下午3:53:25
	 * @throws NotConnectedException
	 */
	public static void disconnect() throws NotConnectedException {
		synchronized(LOCK_OBJ) {
			if(CONN != null) {
				if(CONN.isConnected()) {
					CONN.disconnect();
				}
				CONN = null;
			}
		}
	}
}
