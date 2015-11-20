package com.shin.pay.utils;

import com.google.common.base.Strings;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author shiliang.gao
 * @since 2015-11-16
 */
public class IpUtil {

    private static String ip;

    private static final char SPLITCHAR = '0';

    static {
        try {
            String _ip = getAddress().getLocalHost().getHostAddress();
            ip = Strings.padStart(_ip.substring(_ip.lastIndexOf(".") + 1),3,SPLITCHAR);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static InetAddress getAddress(){
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while ((interfaces.hasMoreElements())){
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback()||networkInterface.isVirtual()||!networkInterface.isUp()){
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                if (addresses.hasMoreElements()){
                    return addresses.nextElement();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getLocalIP(){
        return ip;
    }

    public static void main(String[] args) throws UnknownHostException {
        System.out.println(ip);
        System.out.println(getAddress().getLocalHost().getHostAddress());
    }
}
