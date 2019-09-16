package com.example;

	 
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
import java.util.Arrays;
        import javax.inject.Named;
import packagebean.StudentBean;
import packagebean.coursequizs;
	 
	import weka.clusterers.SimpleKMeans;
	import weka.core.Instances;
	 
@Named(value = "Kmeans")
	public class Kmeans {
    
    
	 
		public static BufferedReader readDataFile(String filename) {
			BufferedReader inputReader = null;
	 
			try {
				inputReader = new BufferedReader(new FileReader(filename));
			} catch (FileNotFoundException ex) {
				System.err.println("File not found: " + filename);
			}
	 
			return inputReader;
		}
	 
		public String Km() throws Exception {
                   
                    //StudentBean ss = new StudentBean();
                    //int x = ss.getMax();
                    int x = 0;
                    System.out.println(x+" hlikiaaaaaa");
                        ΑrffCreator gen = new ΑrffCreator();
			gen.ArffGenerator();
			
			SimpleKMeans kmeans = new SimpleKMeans();
	 
			kmeans.setSeed(2);
	 
			//important parameter to set: preserver order, number of cluster.
			kmeans.setPreserveInstancesOrder(true);
			kmeans.setNumClusters(2);
	 
			BufferedReader datafile = readDataFile("E:\\Users\\Filippos\\Documents\\NetBeansProjects\\MapsCopy\\mytext.arff"); 
			Instances data = new Instances(datafile);
	 
	 
			kmeans.buildClusterer(data);
	 
			// This array returns the cluster number (starting with 0) for each instance
			// The array has as many elements as the number of instances
			int[] assignments = kmeans.getAssignments();
                        int noNoobs=-1;
			//int i=0;
			int g = assignments.length;
                        String studentsLvl = "";
                        String quizAns = "";
                        int clusterResult;
			/*----------------------------------------->xeirokinitos upologismos<----------------------------------------
                        
                        /*for(int clusterNum : assignments) {
                                if(i==x){
                                     noNoobs = assignments[i];
                                System.out.println("to "+g+"o einai "+ clusterNum+"= "+x+" o cluster EINAI PROXORIMENOS");
				}	
                                    if(i==g-1) {
                                        
                                        if(assignments[i] == noNoobs){
                                            studentsLvl = "advanced";
                                            System.out.println("MPAINEI STOUS PROXORIMENOUS"+assignments[i]);
                                            
                                        }
                        else{
                                            studentsLvl = "beginner";
                                        System.out.println("DEN PAEI POY8ENA ETSI")  ;  
                                             }
                                 
			    i++;
			}
                        ---------------------------------------------------------------------------------------------------------*/
                        /*upologizw thn euklideia apostash twn telikwn cluster cendroids apo to shmeio 0,0 
                        auto pou apexei perissotero apo to kentro twn a3onwn , 8a einai to cluster advanced epeidi oso megaluterh hlikia 
                        kai kalutero scor sto preliminary test , toso pio advanced. Ka8w h logiki einai oti enas pio megalos kai diavasmenos ma8hths
                        kaluteros apo enan pio pio mikro kai e3isou diavasmeno ma8hth h enan sunmoliko alla ligotero diavasmeno
                        ----------------------------------------------------------------------------------------------------------*/
                        
                        //1 vazw ta teleutaia clusterCendroids se ena instance			
			Instances clusterCendroid = kmeans.getClusterCentroids();
                        //ta metatrepw se string
			String cluster0 = (clusterCendroid.firstInstance()).toString();
			String cluster1 = (clusterCendroid.lastInstance()).toString();
			System.out.println(cluster0+"++++++++++++++++"+cluster1);
			
                        //2 spaw to ka8e string sto "," gt einai tis morfhs cluster0="x0,y0" cluster1="x1,y1"
			String[] parts = cluster0.split(",");
			String partx0 = parts[0]; // 004
			String party0 = parts[1]; // 034556
	
			System.out.println(partx0+" ||  "+party0);
                        
                        //3 Metatrepw ta String se double metavlites gia na epitrepontai oi pra3eis
			double clusterDx0 = Double.parseDouble(partx0);
			double clusterDy0 = Double.parseDouble(party0);
			System.out.println(clusterDx0+clusterDy0);
			
                        //epanalamvanoume thn diadikasia apo to vhma 2
			String[] parts1 = cluster1.split(",");
			String partx1 = parts1[0]; // 004
			String party1 = parts1[1]; // 034556
			
			System.out.println(partx1+" ||  "+party1);
			
                        
                        double clusterDx1 = Double.parseDouble(partx1);
			double clusterDy1 = Double.parseDouble(party1);
			//System.out.println(clusterDx1+clusterDy2);
                        //ypologizw thn euklidia apostasi twn 2 shmeivn ws pros to 0,0
			double popo = Math.sqrt((Math.pow(clusterDx0,2)+Math.pow(clusterDy0,2)));
			double popo2 = Math.sqrt((Math.pow(clusterDx1,2)+Math.pow(clusterDy1,2)));
                        
			if (Math.max(popo, popo2)==popo) {
                                                    
                                clusterResult=0;
				System.out.println("0=advanced -- "+popo+"--1=begginer "+popo2);
			}
			else {
                                clusterResult=1;
				System.out.println("1=advanced -- "+popo2+"--0=begginer "+popo);
			}
			System.out.println(popo+"||"+popo2+"||");
                        
                       if (assignments[data.numInstances()-1]==clusterResult){
                            studentsLvl = "advanced";
                            quizAns = "yes";
                                            System.out.println("MPAINEI STOUS PROXORIMENOUS "+assignments[data.numInstances()-1]);
                       }
                       else{
                                            quizAns = "no";
                                            studentsLvl = "beginner";
                                        System.out.println("MPAINEI STOUS MH PROXORIMENOUS "+assignments[data.numInstances()-1])  ;  
                                             }
                        
                        coursequizs lev = new coursequizs();
                        lev.studentLevel(studentsLvl,quizAns);
                        
                        System.out.println(Arrays.toString(assignments));
                    return "home.jsf";
		}
	}

