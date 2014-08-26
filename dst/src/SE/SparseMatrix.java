package SE;

import java.util.*;


public class SparseMatrix {
	LinkedList<SMValue> valueList;
	int rows;
	int columns;
	
	SparseMatrix (int rCnt, int cCnt) {
		rows = rCnt;
		columns = cCnt;
		this.valueList = new LinkedList<SMValue>();
	}
	private class SMValue{
		int r;
		int c;
		int v;
		
		SMValue (int ridx, int cidx, int cell_value){
			r = ridx;
			c = cidx;
			v = cell_value;
		}
	};
		
		
		
		void add(int value, int i, int j) {
			SMValue cellValue = new SMValue(i,j,value);
			this.valueList.addLast(cellValue);
			
			return;
		}
		
		public void showSM(){
			System.out.println("Sparse Matrix: " + this.rows + "x" + this.columns);
			
			Iterator<SMValue> itr = this.valueList.iterator();
			SMValue tmp = null;
			int value;
			
			if (itr.hasNext())
				tmp = itr.next();
		
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i<this.rows; i++) {
				for (int j=0; j<this.columns; j++){
					if (tmp != null && tmp.r==i  && tmp.c == j){
						value = tmp.v;
						if (itr.hasNext())
							tmp = itr.next();
						else tmp = null;
					}
					else value = 0;
					
					sb.append(value);
					sb.append(" "); 
					
				} // end for column
				sb.append("\n");
		}// end for row
			System.out.println(sb);
			
	}// showSM() ends
		
	public void findGroups(){
		int grp=0;
		
		Iterator<SMValue> itr = this.valueList.iterator();
		
		SMValue prev = null;
		SMValue curr = null;
		if (itr.hasNext()) {
			curr = itr.next();
			grp =1;
		}
		while (itr.hasNext()){
			prev = curr;
			curr = itr.next();
			if  ((prev.c+1 == curr.c) ^ (prev.r+1 == curr.r)) // XOR 
				continue;
			else grp++;
		}
		System.out.println("Number of groups:" + grp);
		return;
	}
		

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparseMatrix s1 = new SparseMatrix(3,3);
		
		s1.add(1,0,0);
		s1.add(1,1,1);
		//s1.add(1,2,1);
		s1.add(1,2,2);
		s1.showSM();
		s1.findGroups();
		

	}

}
