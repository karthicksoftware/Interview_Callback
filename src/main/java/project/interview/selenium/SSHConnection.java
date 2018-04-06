package project.interview.selenium;

import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SSHConnection {


    /**
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String SFTPHOST = "slottodsweb01.pchoso.com";
        int    SFTPPORT = 22;
        String SFTPUSER = "karunachalam";
        String SFTPPASS = "karunachalam4189";
        String SFTPWORKINGDIR = "/var/www/html/lottods";

        Session     session     = null;
        Channel     channel     = null;
        ChannelSftp channelSftp = null;

        try{
            JSch jsch = new JSch();
            session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp)channel;
            channelSftp.cd(SFTPWORKINGDIR);
            Vector filelist = channelSftp.ls(SFTPWORKINGDIR);
            String buildNumber = null;
            for(int i=0; i<filelist.size();i++){
                LsEntry entry = (LsEntry) filelist.get(i);
                System.out.println(entry.getFilename());
                if(entry.getFilename().endsWith("-stg")){
                	buildNumber = entry.getFilename();
                }
            }
            System.out.println(buildNumber);
            SFTPWORKINGDIR = SFTPWORKINGDIR +"/"+ buildNumber;
            System.out.println(SFTPWORKINGDIR);
            channelSftp.cd(buildNumber);
            filelist = channelSftp.ls(SFTPWORKINGDIR);
            for(int i=0; i<filelist.size();i++){
                LsEntry entry = (LsEntry) filelist.get(i);
                System.out.println(entry.getFilename());
            }
            
            channel = session.openChannel("exec");
            String command = "sudo -u apache php artisan content:import:all";
            ((ChannelExec)channel).setCommand(command);
            channel.connect();
            channel.run();
            command = "sudo -u apache php artisan content:cache:all";
            ((ChannelExec)channel).setCommand(command);
            channel.connect();
            channel.run();
            System.out.println("done");
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
