import java.util.*;
import java.lang.*;
class game{
	public static int c=0;
	int generate_shape(){
		int num=(int)(Math.random() *5);
		return num;
		
	}
	public static void main(String args[]){
		int shape_num,val=0;
		char key;
		int flag=0;
		Scanner sc=new Scanner(System.in);
		board b=new board();
		shape s=new shape();
		game g=new game();
		b.set_board_initial();
		do{
		val=0;
		int curr_state=0;
		shape_num=g.generate_shape();
		s.set_curr_shape(shape_num);
		s.set_initial_shape();
		s.set_s();
		point[] p=s.get_points();
		b.print_board(p);
		do{
		key=sc.next().charAt(0);
		if(key=='A'||key=='a'){
			s.move_left();
			b.print_board(p);
		}
		else if(key=='D'||key=='d'){
			s.move_right();
			b.print_board(p);
		}
		else if(key=='S'||key=='s'){
			val=s.move_down();
			b.print_board(p);
		}
		else if(key=='R'||key=='r'){
			s.set_curr_state(curr_state);
			s.rotate();
			b.print_board(p);
			curr_state++;
			if(curr_state==4)
				curr_state=0;
		}
		else if(key=='U'||key=='u'){
			
		}
		if(val==1){
			b.set_board(p);
			b.check_board();
			char b1[][]=b.get_board();
			s.fix_board(b1);
			
		}
		}while(val!=1&&(key!='q'&&key!='Q'));
		}while(key!='q'&&key!='Q');
	}
}
