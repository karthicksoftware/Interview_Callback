package project.interview.selenium;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SampleSSH {

	public static void main(String[] arg) throws JSchException, IOException, SftpException {

		String host = "qlottodsweb01.pchoso.com";
		String login = "karunachalam";
		String password = "karunachalam4189";
		String command0 = "cd /var/www/html/lottods/lottods_site-0.0.1088-ec365fd2cb96a4a3aa1cacebb1a48717604ba750-qa";
		String command1 = "sudo -u apache php artisan content:import:all";
		String command2 = "sudo -u apache php artisan content:cache:all";
		List<String> commands = new ArrayList<String>();
		commands.add(command0);
	    commands.add(command1);
	    commands.add(command2);

		// If you don't have already accept the public key or else
		// you will have the error <em>com.jcraft.jsch.JSchException:
		// UnknownHostKey: hostname</em>

		try {
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(login, host, 22);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");
			Channel channel;
			/*Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp channelSftp;
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd("/var/www/html/lottods/lottods_site-0.0.1088-ec365fd2cb96a4a3aa1cacebb1a48717604ba750-qa");
			channelSftp.disconnect();*/

			 channel=session.openChannel("shell");//only shell  
		        channel.setOutputStream(System.out); 
		        PrintStream shellStream = new PrintStream(channel.getOutputStream());  // printStream for convenience 
		        channel.connect(); 
		        for(String command: commands) {
		        	System.out.println("Test");
		            shellStream.println(command);		            
		            shellStream.flush();
		            System.out.println("after flush");
		        }

		        Thread.sleep(2000);
		        System.out.println("Outside for");
			channel.disconnect();
			System.out.println("channel disconnect");
			session.disconnect();
			System.out.println("session disconnect");
			System.out.println("DONE");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception");
		}

	}

}
