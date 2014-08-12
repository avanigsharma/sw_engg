package SE;

public class Matrix {
	
	int row, col;
	int[][] values;
	
	Matrix(int r, int c ){
		this.row = r;
		this.col = c;
		values = new int[r][c];
	}

	Matrix( int[][] v){
		
		this.row = v.length;
		this.col = v[0].length;
		values = new int[row][col];
		for (int i=0; i < row; i++)
			for (int j=0; j< col; j++)
				values[i][j] = v[i][j];
	}
	
	/* print it out */
	public void show(){
		System.out.println("Matrix: " + row +"x"+col);
		for (int i=0; i<row; i++) {
			StringBuilder str= new StringBuilder();
			for (int j=0; j<col; j++) {
				str.append(values[i][j]);
				str.append(" ");
			}
			System.out.println(str);
		}
	}
	
	public Matrix transpose(){
		Matrix tm  = new Matrix(col,row);
		for (int i=0; i < row; i++)
			for (int j=0; j< col; j++)
				tm.values[j][i] = this.values[i][j];
				
		return tm;
	}
	
	public Matrix rotate_90(){
		Matrix tm  = new Matrix(col,row);
		for (int i=0; i < row; i++)
			for (int j=0; j< col; j++)
				tm.values[j][row-i-1] = this.values[i][j];
				
		return tm;
	}
	public Matrix multiply(Matrix m2){
		Matrix tm = new Matrix(this.row, m2.col);
		for (int i=0; i < this.row; i++)
			for (int j=0; j< m2.col; j++){
				int sum = 0;
				for (int k=0; k<col; k++)
					sum += (this.values[i][k]) * (m2.values[k][j]);
				tm.values[i][j] = sum;
			}
		return tm;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] t = {{1,2,3}, {3,4,5}, {6,7,8}, {3,3,3}};
		
		Matrix m1 = new Matrix(t);
		m1.show();
		m1.transpose().show();
		m1.rotate_90().show();
		m1.multiply(m1.transpose()).show();
		

	}

}
