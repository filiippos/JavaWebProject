/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packagebean;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;

/**
 *
 * @author NICK
 */
@ManagedBean(name= "uplCtrl")
public class UploadController {
    
    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
    public String upload() throws IOException
    {  
        //get path which contain file uploaded
      //  String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("homework");
      //  path=path.subString(0,path.indexOf("\\build"));
     //   path = path+"\\web\files\\homework\\";
        //writing file to path
        
       
        //    try {
          //      InputStream in=file.getInputStream();
            //    byte[] data = new byte[in.available()];
              //  FileOutputStream out = new FileOutputStream(new File(path + "homework.jpg"));
           //     out.write(data);
             //   in.close();
              //  out.close();
               //         } 
        //    catch (IOException ex) {
        //        Logger.getLogger(UploadController.class.getName()).log(Level.SEVERE, null, ex);
          //  }
       // }
        
        file.write("students_projects"+getFileName(file));
        return "successfulupload.jsf";
    }
    
    private static String getFilename(Part part)
    {
        for(String cd: part.getHeader("content-disposition").split(";")){
            if(cd.trim().startsWith("filename"))
            {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"","");
                return filename.substring(filename.lastIndexOf('/') + 1 ).substring(filename.indexOf('\\') + 1 );
            }
        }
        return null;
    }
    
}
