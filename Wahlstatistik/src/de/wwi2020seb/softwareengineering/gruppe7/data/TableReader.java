package de.wwi2020seb.softwareengineering.gruppe7.data;

public class TableReader {
	
	/*
	
	public TableReader() {
		
	}
	
	public Object getTable(TableType t, File f) {
		
		 BufferedReader br = null;
	     String line = "";
	     String cvsSplitBy = ";";
	     
	     try {
	    	 String[] result;
	    	 int[][] table = null;
	    	 double[][] table2 = null;
	    	 String[][] table3 = null;
	    	 
	    	 int size = 0, size2 = 0;
	    	 
	    	 br = new BufferedReader(new FileReader(f));
	         while ((line = br.readLine()) != null) {
	        	 size2 = line.split(cvsSplitBy).length;
	        	 size++;
	         }
	         br.close();
	         
	    	 int i = 0;
	    	 table = new int[size][size2];
			 table2 = new double[size][size2];
        	 table3 = new String[size][size2];

	         br = new BufferedReader(new FileReader(f));
	         while ((line = br.readLine()) != null) {

	             result = line.split(cvsSplitBy);
	             switch (t) {
		         case INT:
		             for(int j = 0; j<result.length; j++) {
		            	 table[i][j] = Integer.parseInt(result[j]);
		             }
		             break;
				 case DOUBLE:
		             for(int j = 0; j<result.length; j++) {
		            	 table2[i][j] = Double.parseDouble(result[j]);
		             }
		             break;
		         case STRING:
		             for(int j = 0; j<result.length; j++) {
		            	 table3[i][j] = result[j];
		             }
		             break;
			         
		         default:
		             System.out.println("Programmfehler");
		         }
	             
	             i++;

	         }
	         
	         switch(t) {
	         case INT:
	        	 return table;
	         case DOUBLE:
	         	 return table2;
	         case STRING:
	        	 return table3;
	         }
	         

		     br.close();

	     } catch (FileNotFoundException e) {
	         e.printStackTrace();
	     } catch (IOException e) {
	         e.printStackTrace();
	     } finally {
	         if (br != null) {
	             try {
	                 br.close();
	             } catch (IOException e) {
	                 e.printStackTrace();
	             }
	         }
	     }
	     
	     
		return null;
		
	}
	
	*/
	
}
