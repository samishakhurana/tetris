public class shape{
	char board_copy[][]=new char[200][200];
	private point p[]=new point[4];
	private int curr_shape;
	private int curr_state;
	private point[][][] s=new point[5][4][4];
	public shape(){
		int i,j,k;
		for(i=0;i<4;i++)
			p[i]=new point();
		for(i=0;i<5;i++){
			for(j=0;j<4;j++){
				for(k=0;k<4;k++){
					s[i][j][k]=new point();
				}
			}
		}
	}
	void set_curr_shape(int num){
		curr_shape=num;
	}
	void set_curr_state(int num){
		curr_state=num;
	}
	point[] get_points(){
		return p;
	}
	void move_left(){
		int c[]=new int[4];
		int i,flag=0;
		for(i=3;i>=0;i--){
			c[i]=p[i].y-1;
		}
		if(check_board_lr(c,p)==1){
			flag=1;
		}
		else{
		for(i=0;i<4;i++){
			if(c[i]>0)
				flag=0;
			else{
				flag=1;
				break;
			}
		}
		}
		if(flag==0){
			for(i=0;i<4;i++){
				p[i].y=c[i];
			}
		}
	}
	void move_right(){
		int c[]=new int[4];
		board b=new board();
		int i,flag=0;
		for(i=3;i>=0;i--){
			c[i]=p[i].y+1;
		}
		if(check_board_lr(c,p)==1){
			flag=1;
		}
		else{
		for(i=0;i<4;i++){
			if(c[i]<=(b.get_maxc()-2))
				flag=0;
			else{
				flag=1;
				break;
			}
		}
		}
		if(flag==0){
			for(i=0;i<4;i++){
				p[i].y=c[i];
			}
		}
		
	}
	int move_down(){
		int r[]=new int[4];
		int flag=0,i;
		int c;
		board b1=new board();
		for(i=3;i>=0;i--){
			r[i]=p[i].x+1;
		}
		if(check_board_down(r,p)==1){
			flag=1;
		}
		else{
		for(i=3;i>=0;i--){
				if(r[i]<(b1.get_maxr()-1)){
					flag=0;
				}
				else{
					flag=1;
					break;
				}
			}
		if(flag==0){
			for(i=0;i<4;i++){
				p[i].x=r[i];
			}
		}
		}
		return flag;
	}
	int check_board_down(int r[],point p[]){
		int i,flag=0;
		for(i=0;i<4;i++){
			if(board_copy[r[i]][p[i].y]=='#'){
				flag=1;
				break;
			}
		}
		return flag;
	}
	int check_board_lr(int c[],point p[]){
		int i,flag=0;
		for(i=0;i<4;i++){
			if(board_copy[p[i].x][c[i]]=='#'){
				flag=1;
				break;
			}
		}
		return flag;
	}
	void fix_board(char b[][]){
		board b1=new board();
		int i,j;
		for(i=0;i<b1.get_maxr();i++){
			for(j=0;j<b1.get_maxc();j++){
				board_copy[i][j]=b[i][j];
			}
		}
		
	}
	void set_initial_shape(){
		int r=0,c=10,i=0;
		if(curr_shape==0){
			for(i=0;i<3;i++){
				p[i].x=r;
				p[i].y=c;
				c++;
			}
			p[i].x=r+1;
			p[i].y=--c;
		}
		else if(curr_shape==1){
			for(i=0;i<3;i++){
				p[i].x=r;
				p[i].y=c;
				c++;
			}
			c=c-2;
			p[i].x=r+1;
			p[i].y=c;
		}
		else if(curr_shape==2){
			for(i=0;i<4;i++){
				p[i].x=r;
				p[i].y=c;
				c++;
			}
		}
		else if(curr_shape==3){
			p[0].x=r;
			p[0].y=c;
			p[1].x=r;
			p[1].y=c+1;
			p[2].x=r+1;
			p[2].y=c;
			p[3].x=r+1;
			p[3].y=c+1;
		}
		else if(curr_shape==4){
			p[0].x=r;
			p[0].y=c;
			p[1].x=r+1;
			p[1].y=c;
			p[2].x=r+1;
			p[2].y=c-1;
			p[3].x=r+2;
			p[3].y=c-1;
		}
		
	}
	void set_s(){
		int i,j,k;
		s[0][0][0].x=-2;
		s[0][0][0].y=0;
		s[0][0][1].x=-1;
		s[0][0][1].y=1;
		s[0][0][2].x=0;
		s[0][0][2].y=2;
		s[0][0][3].x=1;
		s[0][0][3].y=1;
		
		s[0][1][0].x=0;
		s[0][1][0].y=2;
		s[0][1][1].x=1;
		s[0][1][1].y=1;
		s[0][1][2].x=2;
		s[0][1][2].y=0;
		s[0][1][3].x=1;
		s[0][1][3].y=-1;
		
		s[0][2][0].x=2;
		s[0][2][0].y=0;
		s[0][2][1].x=1;
		s[0][2][1].y=-1;
		s[0][2][2].x=0;
		s[0][2][2].y=-2;
		s[0][2][3].x=-1;
		s[0][2][3].y=-1;
		
		s[0][3][0].x=0;
		s[0][3][0].y=-2;
		s[0][3][1].x=-1;
		s[0][3][1].y=-1;
		s[0][3][2].x=-2;
		s[0][3][2].y=0;
		s[0][3][3].x=-1;
		s[0][3][3].y=1;
		
		s[1][0][0].x=-2;
		s[1][0][0].y=0;
		s[1][0][1].x=-1;
		s[1][0][1].y=1;
		s[1][0][2].x=0;
		s[1][0][2].y=2;
		s[1][0][3].x=0;
		s[1][0][3].y=0;
		
		s[1][1][0].x=0;
		s[1][1][0].y=2;
		s[1][1][1].x=1;
		s[1][1][1].y=1;
		s[1][1][2].x=2;
		s[1][1][2].y=0;
		s[1][1][3].x=0;
		s[1][1][3].y=0;
		
		s[1][2][0].x=2;
		s[1][2][0].y=0;
		s[1][2][1].x=1;
		s[1][2][1].y=-1;
		s[1][2][2].x=0;
		s[1][2][2].y=-2;
		s[1][2][3].x=0;
		s[1][2][3].y=0;
		
		s[1][3][0].x=0;
		s[1][3][0].y=-2;
		s[1][3][1].x=-1;
		s[1][3][1].y=-1;
		s[1][3][2].x=-2;
		s[1][3][2].y=0;
		s[1][3][3].x=0;
		s[1][3][3].y=0;
		
		s[2][0][0].x=-2;
		s[2][0][0].y=0;
		s[2][0][1].x=-1;
		s[2][0][1].y=1;
		s[2][0][2].x=0;
		s[2][0][2].y=2;
		s[2][0][3].x=1;
		s[2][0][3].y=3;
		
		s[2][1][0].x=-1;
		s[2][1][0].y=3;
		s[2][1][1].x=0;
		s[2][1][1].y=2;
		s[2][1][2].x=1;
		s[2][1][2].y=1;
		s[2][1][3].x=2;
		s[2][1][3].y=0;
		
		s[2][2][0].x=1;
		s[2][2][0].y=0;
		s[2][2][1].x=0;
		s[2][2][1].y=-1;
		s[2][2][2].x=-1;
		s[2][2][2].y=-2;
		s[2][2][3].x=-2;
		s[2][2][3].y=-3;
		
		s[2][3][0].x=2;
		s[2][3][0].y=-3;
		s[2][3][1].x=1;
		s[2][3][1].y=-2;
		s[2][3][2].x=0;
		s[2][3][2].y=-1;
		s[2][3][3].x=-1;
		s[2][3][3].y=0;
		
		for(j=0;j<4;j++){
			for(k=0;k<4;k++){
				s[3][j][k].x=0;
				s[3][j][k].y=0;
			}
		}
		
		s[4][0][0].x=0;
		s[4][0][0].y=2;
		s[4][0][1].x=1;
		s[4][0][1].y=1;
		s[4][0][2].x=0;
		s[4][0][2].y=0;
		s[4][0][3].x=1;
		s[4][0][3].y=-1;
		
		s[4][1][0].x=1;
		s[4][1][0].y=1;
		s[4][1][1].x=0;
		s[4][1][1].y=0;
		s[4][1][2].x=-1;
		s[4][1][2].y=1;
		s[4][1][3].x=-2;
		s[4][1][3].y=0;
		
		s[4][2][0].x=1;
		s[4][2][0].y=-2;
		s[4][2][1].x=0;
		s[4][2][1].y=-1;
		s[4][2][2].x=1;
		s[4][2][2].y=0;
		s[4][2][3].x=0;
		s[4][2][3].y=1;
		
		s[4][3][0].x=-2;
		s[4][3][0].y=-1;
		s[4][3][1].x=-1;
		s[4][3][1].y=0;
		s[4][3][2].x=0;
		s[4][3][2].y=-1;
		s[4][3][3].x=1;
		s[4][3][3].y=0;
		
	}
	void rotate(){
		board b=new board();
		int i,flag=0;;
		int r[]=new int[4];
		int c[]=new int[4];
		int cs=curr_state+1;
		if(cs==4)
			cs=0;
		for(i=0;i<4;i++){
			r[i]=p[i].x+s[curr_shape][cs][i].x;
			c[i]=p[i].y+s[curr_shape][cs][i].y;
		}
		for(i=0;i<4;i++){
			if(r[i]>=0&&r[i]<b.get_maxr()&&c[i]>0&&c[i]<b.get_maxc()-2){
				flag=0;
			}
			else{
				flag=1;
				break;
			}
		}
		if(flag==0){
			for(i=0;i<4;i++){
				p[i].x=r[i];
				p[i].y=c[i];
			}
		}
	}
}