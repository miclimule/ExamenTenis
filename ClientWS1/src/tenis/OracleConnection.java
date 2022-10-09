package tenis;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.time.LocalDate;

public class OracleConnection {
	
	public Statement stmt;
	public Connection con;

	public void insert(Object o , String tab , String primary)
	  {
	  	try
	    {
	    	String req = "insert into "+ tab + " values (";
	    	Field[] f = o.getClass().getFields();
			Method[] m = o.getClass().getMethods();
			Method[] getter = getGetterInTableOracle(m,tab);

			Field[] use =  getUseFieldsInTableOracle(f,tab);

			Object[][] obj = select(o,tab);

	    	for (int i = 0 ; i<use.length ; i++) {
				if (use[i].getName().equalsIgnoreCase(primary)) {
					req= req + "" + obj.length + ", ";
				}
				else if (i==(use.length -1)) {
					
					if(use[i].toString().indexOf(" int ")!=-1){
						req = req + getter[i].invoke(o);
					}
					else if(use[i].toString().indexOf("String ")!=-1){
						req = req +"'"+ getter[i].invoke(o) +"'";
					}
					else if(use[i].toString().indexOf("LocalDate ")!=-1){
						LocalDate ld =(LocalDate)getter[i].invoke(o) ;
						req = req +"to_date('"+ld.getYear()+"/"+ld.getMonthValue()+"/"+ld.getDayOfMonth()+"','YYYY/MM/DD')"; 
					}
				}
				else{
					
					if(use[i].toString().indexOf(" int ")!=-1){
						req = req + getter[i].invoke(o) + ",";
					}
					else if(use[i].toString().indexOf("String ")!=-1){
						req = req +"'"+ getter[i].invoke(o) + "',";
					}
					else if(use[i].toString().indexOf("LocalDate ")!=-1){
						LocalDate ld =(LocalDate)getter[i].invoke(o) ;
						req = req +"to_date('"+ld.getYear()+"/"+ld.getMonthValue()+"/"+ld.getDayOfMonth()+"','YYYY/MM/DD'),";
					}

				}
			}

	    	req = req + ")";
	    		System.out.println(req);
			ResultSet res = stmt.executeQuery(req);
			 


	    }
	    catch(Exception e){ 
	      e.printStackTrace(); 
	    }
	}

	public void update(Object o , String tab , String primary){
		try{
			String req = "update "+tab+" set ";
			Field[] f = o.getClass().getFields();
			Method[] m = o.getClass().getMethods();
			Method[] getter = getGetterInTableOracle(m,tab);
			Field[] use =  getUseFieldsInTableOracle(f,tab);

	    	for(int i =0;i<use.length;i++){
	    		System.out.println(use[i].getName());
	    	}

			for (int i = 0 ; i<use.length ; i++) {
				if (i==(use.length -1)) {
					if(use[i].toString().indexOf(" int ")!=-1){
						System.out.println(use[i].getName());
						req = req +use[i].getName() +"="+ getter[i].invoke(o);
					}
					else if(use[i].toString().indexOf("String ")!=-1){
						System.out.println(use[i].getName());
						req = req +use[i].getName()+"='"+ getter[i].invoke(o) +"' ";
					}
					else if(use[i].toString().indexOf("LocalDate ")!=-1){
						System.out.println(use[i].getName());
						LocalDate ld =(LocalDate)getter[i].invoke(o) ;
						req = req +use[i].getName()+"='"+ld.getDayOfMonth()+"-"+ld.getMonthValue()+"-"+ld.getYear() +"' ";
					}
				}
				else{
					
					if(use[i].toString().indexOf(" int ")!=-1){
						System.out.println(use[i].getName());
						req = req +use[i].getName()+"="+ getter[i].invoke(o) + ", ";
					}
					else if(use[i].toString().indexOf("String ")!=-1){
						System.out.println(use[i].getName() + "Strind");
						req = req +use[i].getName()+"='"+ getter[i].invoke(o) + "', ";
					}
					else if(use[i].toString().indexOf("LocalDate ")!=-1){
						System.out.println(use[i].getName());
						LocalDate ld =(LocalDate)getter[i].invoke(o) ;
						req = req +use[i].getName()+"='"+ld.getDayOfMonth()+"-"+ld.getMonthValue()+"-"+ld.getYear() +"', ";
					}

				}
			}

			for (int i = 0;i<use.length ;i++ ) {
				if (use[i].getName().equalsIgnoreCase(primary)) {
					req=req+"where " +use[i].getName() + "=" +getter[i].invoke(o);
				}
			}
			System.out.println(req);

			this.stmt.executeQuery(req);

		}
		catch(Exception e){ 
	      e.printStackTrace();
	    }
	}

	public Object[][] select(Object o , String tab){
		try{

			ResultSet res = stmt.executeQuery("select * from "+tab);
			Field[] f = o.getClass().getFields();
			Field[] use =  getUseFieldsInTableOracle(f,tab);
			res = stmt.executeQuery("select * from "+tab);
			ResultSetMetaData rsmd = res.getMetaData();
			int columnCount = rsmd.getColumnCount();
			Object[][] ob = new Object[countElements(tab)+1][columnCount];

			for (int i = 1; i <= columnCount; i++ ) {
			  ob[0][i-1] = rsmd.getColumnName(i);
			}


			ResultSet res2 = stmt.executeQuery("select * from "+tab);
			int i = 1;
			while (res2.next()) {
				for (int j =0;j<ob[i].length ;j++ ) {
					if(use[j].toString().indexOf(" int ")!=-1){
						ob[i][j] = res2.getInt(j+1);
					}
					else if(use[j].toString().indexOf("String ")!=-1){
						ob[i][j] = res2.getString(j+1);
					}
					else if(use[j].toString().indexOf("LocalDate ")!=-1){
						ob[i][j] = res2.getString(j+1);
					}
					if(use[j].toString().indexOf(" double ")!=-1){
						ob[i][j] = res2.getDouble(j+1);
					}
				}
				i++;
			}
			// System.out.println(res.getInt(1)+"  "+res.getString(2));
			return ob;
	    }
	    catch(Exception e){ 
	      e.printStackTrace(); 
	    }
		return null;
	}

	public int countElements(String tab){
		int i=0;
		try{
			ResultSet res = stmt.executeQuery("select * from "+tab);
			while(res.next()){
				i++;
			}
		}
		catch(Exception e){ 
	      e.printStackTrace(); 
	    }
		return i;
	}

	// public int countElements2(String tab){
	// 	int i=0;
	// 	try{
	// 		ResultSet res = stmt.executeQuery("select ideq,sum(points) from "+tab +" group by ideq");
	// 		while(res.next()){
	// 			i++;
	// 		}
	// 	}
	// 	catch(Exception e){ 
	//       e.printStackTrace(); 
	//     }
	// 	return i;
	// }

	public Field[] getUseFieldsInTableOracle(Field[] f , String tab){
		try{
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tab);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			String[] names = new String[columnCount];
			
				for (int i = 0; i < columnCount; i++ ) {
				  names[i] = rsmd.getColumnName(i+1);
				}

			Field[] use = new Field[columnCount];

			for (int i = 0; i<names.length ; i++ ) {
				for (int j = 0; j<f.length ; j++ ) {
					if (f[j].getName().equalsIgnoreCase(names[i])) {
						use[i] = f[j];
					}
				}
			}

			return use;
		}
		catch(Exception e){ 
	      e.printStackTrace();
	    }

	    return null;
	}

	public Method[] getGetterInTableOracle(Method[] m , String tab){
		try{
			ResultSet rs = stmt.executeQuery("SELECT * FROM " +tab);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			String[] names = new String[columnCount];
			
				for (int i = 0; i < columnCount; i++ ) {
				  names[i] = rsmd.getColumnName(i+1);
				}

			Method[] getM = new Method[columnCount];

			for (int i = 0 ; i<columnCount ; i++ ) {
				for (int j = 0 ; j<m.length ; j++ ) {
					if (m[j].getName().startsWith("get"+names[i])) {
						getM[i] = m[j];
					}
				}
			}

			return getM;
		}
		catch(Exception e){ 
	      e.printStackTrace(); 
	    }
		
	    return null;
	}

	public void open_connection_psql(){
		try{
			Class.forName("org.postgresql.Driver");
	      
	       this.con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","root");

	      this.stmt = this.con.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void close_connection_psql(){
		try{
			con.commit();
			con.close();
		}
		catch(Exception e){}
	}

	public static boolean isGetter(Method method) {
		boolean result = method.getName().startsWith("get")
	        && (method.getParameterTypes().length == 0)
	        && (!Void.class.equals(method.getReturnType()));
		return result;
	}

	public static boolean isSetter(Method method) {
		boolean result = (method.getName().startsWith("set"))
	        && (method.getParameterTypes().length == 1);
		return result;
	}

	public void open_connection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	      
	       this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:newbase","system","root");

	       this.stmt = this.con.createStatement();
		}
		catch(Exception e){
			System.out.println("open");
			e.printStackTrace();
		}
	}

	public void close_connection(){
		try{
			con.close();
		}
		catch(Exception e){System.out.println(e);}
	}
}
