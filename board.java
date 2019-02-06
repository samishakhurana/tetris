public class board{
	private int maxr=20;
	private int maxc=20;
	private char b[][]=new char[maxr][maxc];
	int get_maxr(){
		return maxr;
	}
	int get_maxc(){
		return maxc;
	}
	void set_board_initial(){
		int i=0,j=0;
		for(i=0;i<maxr;i++){
			for(j=0;j<maxc;j++){
				b[i][j]=' ';
			}
		}
		
	}
	char[][] get_board(){
		return b;
	}
	void set_board(point p[]){
		int i=0,j=0;
		for(i=0;i<4;i++){
			b[p[i].x][p[i].y]='#';
		}
	}
	void print_board(point p[]){
		int i,j;
		for(i=0;i<4;i++){
			b[p[i].x][p[i].y]='#';
		}
		for(j=0;j<maxc;j++){
			b[maxr-1][j]='*';
		}
		for(i=0;i<maxr;i++){
			b[i][0]='*';
		}
		for(i=0;i<maxr;i++){
			b[i][maxc-1]='*';
		}
		for(i=0;i<maxr;i++){
			for(j=0;j<maxc;j++){
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
		for(i=0;i<4;i++){
			b[p[i].x][p[i].y]=' ';
		}
	}
	void print_undo_board(char board[][]){
		int i,j;
		for(i=0;i<maxr;i++){
			for(j=0;j<maxc;j++){
				System.out.println(board[i][j]);
			}
		}
	}
	void check_board(){
		int c=0;
		int i,j,flag=0,k,l;
		for(i=maxr-2;i>=0;i--){
			c=0;
			flag=0;
			for(j=1;j<maxc-1;j++){
				if(b[i][j]==' '){
					flag=1;
					break;
				}
				else{
					flag=0;
				}
			}
			if(flag==0){
				for(k=1;k<maxc-1;k++){
					b[i][k]=' ';
				}
				for(k=i-1;k>=0;k--){
					for(j=1;j<maxc-1;j++){
						b[k+1][j]=b[k][j];
						b[k][j]=' ';
					}
				}
				i=i-1;
			}
		}
	}
	
}