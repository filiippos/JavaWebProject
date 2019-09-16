package com.example;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;
import packagebean.Login;

@ManagedBean
@RequestScoped
public class Bean {

   boolean uploaded=false;
    private UploadedFile uploadedFile;
     Connection conn = null;

    public void submit() throws IOException, SQLException {
        String fileName = FilenameUtils.getName(uploadedFile.getName());
        String contentType = uploadedFile.getContentType();
        byte[] bytes = uploadedFile.getBytes();
         System.out.println(Arrays.toString(bytes));
         if(fileName.equals("") || fileName.isEmpty())
         {
            contentType="";
            bytes[0]=0;
            bytes[1]=0;
            uploaded= false;
         }
         else {
             uploaded = true;
              OutputStream out = null;

try {
    out = new BufferedOutputStream(new FileOutputStream("E:\\\\Users\\\\Filippos\\\\Documents\\\\NetBeansProjects\\\\MapsCopy\\\\homework\\\\"+fileName));
    out.write(bytes);
} finally {
    if (out != null) out.close();
}
         }
         
        

        // Now you can save bytes in DB (and also content type?)
        
     //   String query = "update students \n" +
//"set homework ="+bytes+"\n" +
//"where firstname = "+Login.firstname+"";
//PreparedStatement pstmt = conn.prepareStatement(query);

//pstmt.setBytes(1, bytes);
//pstmt.execute();
        
      ////  FilePermission permission = new FilePermission("NICK-PC\\Users\\NICK\\\\data", "write");
////FileOutputStream fos = new FileOutputStream("C:\\Users\\NICK\\data");

////fos.write(bytes);
////fos.close();
         /*
          try {
         FileOutputStream fileOuputStream = 
                  new FileOutputStream("C:\\\\Users\\\\NICK\\\\data"+fileName); 
	    fileOuputStream.write(bytes);
	    fileOuputStream.close();
	       
	    System.out.println("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
          */
         
          
          
          if(uploaded==true){
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(String.format("File '%s' of type '%s' successfully uploaded!", fileName, contentType)));
          }
          else {
              FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(String.format("No file chosen", fileName, contentType)));
          }
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    

}