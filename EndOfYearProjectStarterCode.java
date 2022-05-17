import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class EndOfYearProjectStarterCode extends JPanel implements KeyListener,Runnable
{
	private int x;
	private int y;
	private int a;
	private int b;
	private boolean dir;
	private boolean dir2;
	private int h;
	private int fails;
	private Rectangle h1,h2,h3,h4,h5,h6,h7,h8,p;
	private Rectangle v1,v2,v3,v4,v5,v6,v7,v8;
	private Rectangle e1,e2,e3,e4,e5;
	private JFrame frame;
	private Thread t;
	private boolean gameOn;
	private Font f;
	private Color backGround;
	private Color gre;
	private int speed;
	private int eSpeed;
	private int eSpeed1;
	private int vert;
	private int hori;

	public EndOfYearProjectStarterCode()
	{
		frame=new JFrame();
		x=150;
		y=160;
		a = 225;
		b = 220;
		dir = true;
		dir2 = false;
		h = 520;
		gre =  new Color(158, 242, 155);
		backGround = new Color(171,162,252);
		speed = 2;
		eSpeed = 3;
		eSpeed1 = 3;
		vert = 0;
		hori = 0;
		gameOn = true;
		f=new Font("ARIAL",Font.PLAIN,30);
		frame.addKeyListener(this);
		frame.add(this);
		frame.setSize(810,640);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t=new Thread(this);
		t.start();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		//all painting (AND ONLY PAINTING) happens here!
		//Don't use this method to deal with mathematics
		//The painting imps aren't fond of math.

		//fill background

		g2d.setPaint(Color.BLACK);
		g2d.fillRect(0,0,810,640);
		g2d.setPaint(backGround);
		g2d.fillRect(0,50,1000,600);


		//draw scoreboard
		g2d.setColor(Color.WHITE);
		g2d.setFont(f);
		g2d.drawString("LEVEL: 1",25,40);
		g2d.drawString("FAILS: " + fails,600,40);

		//draw canyon
		g2d.setColor(gre);
		g2d.fillRect(50,160,130,290);//first rect on left
		g2d.setColor(Color.BLACK);
		g2d.fillRect(50,160,5,290);//leftmost border v1
		g2d.fillRect(50,160,130,5);//leftTop border h1
		g2d.fillRect(50,450,230,5);//leftBottom border h2
		g2d.fillRect(180,160,5,240);//leftRight border v2




		g2d.setColor(Color.WHITE);
		g2d.fillRect(180,400,100,50);//first connecter rect
		g2d.setColor(Color.BLACK);
		g2d.fillRect(180,400,45,5);//top connector border h3
		g2d.fillRect(280,400,5,55);//right connector border v3

		g2d.setColor(Color.WHITE);
		g2d.fillRect(220,210,320,190);//big middle rect
		g2d.setColor(Color.BLACK);
		g2d.fillRect(220,210,5,190);//left middle rect border v4
		g2d.fillRect(225,210,255,5);//top middle rect border h4
		g2d.fillRect(280,400,260,5);//bottom middle rect border h5
		g2d.fillRect(540,210,5,195);//right middle rect border v5

		g2d.setColor(Color.WHITE);
		g2d.fillRect(480,160,100,50);//2nd connecter rect
		g2d.setColor(Color.BLACK);
		g2d.fillRect(480,160,5,55);//left connector border v6
		g2d.fillRect(540,210,40,5);//bottom connector border h6


		g2d.setColor(gre);
		g2d.fillRect(580,160,130,290);//2nd rect on right
		g2d.setColor(Color.BLACK);
		g2d.fillRect(480,160,230,5);//top right rect border h7
		g2d.fillRect(580,210,5,240);//left right rect border v7
		g2d.fillRect(710,160,5,290);//rightmost right rect border v8
		g2d.fillRect(580,450,135,5);//bottom right rect border h8

		//Your character
		g2d.setColor(Color.BLACK);
		g2d.fillRect(x,y,24,24);
		g2d.setColor(Color.RED);
		g2d.fillRect(x+4,y+4,16,16);

		//Other characters
		g2d.setColor(Color.BLACK);
		g2d.fillOval(a,b,15,15);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(a+3,b+3,9,9);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(h,b+38,15,15);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(h + 3,b + 41,9,9);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(a,b + 76,15,15);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(a + 3,b+79,9,9);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(h,b + 114,15,15);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(h + 3,b+117,9,9);

		g2d.setColor(Color.BLACK);
		g2d.fillOval(a,b + 160,15,15);
		g2d.setColor(Color.BLUE);
		g2d.fillOval(a + 3,b+163,9,9);

		if(x > 548)
		{
			gameOn = false;
			g2d.drawString("YOU WON",150,200);


		}
	}
	public void run()
		{
			while(true)
			{
				if(gameOn)
				{
					//MATH HAPPENS HERE!!!!
					//keep count of steps

					//randomly generate new top row of walls.
					//eliminate bottom row of walls

					//check to see if you've hit a wall

					//modify points

					//check to see if you've increased a level - if so, increase it

					//check for crashes

					p = new Rectangle(x,y,24,24);

					e3 = new Rectangle(a,b,10,10);
					e1 = new Rectangle(h,b+38,10,10);
					e4 = new Rectangle(a,b + 76,10,10);
					e2 = new Rectangle(h,b + 114,10,10);
					e5 = new Rectangle(a,b + 160,10,10);



					v1 = new Rectangle(50,160,5,290);
					v2 = new Rectangle(180,160,5,240);
					v3 = new Rectangle(280,400,5,55);
					v4 = new Rectangle(220,210,5,190);
					v5 = new Rectangle(540,210,5,195);
					v6 = new Rectangle(480,160,5,55);
					v7 = new Rectangle(580,210,5,240);
					v8 = new Rectangle(710,160,5,290);


					h1 = new Rectangle(50,160,130,5);
					h2 = new Rectangle(50,450,230,5);
					h3 = new Rectangle(180,400,45,5);
					h4 = new Rectangle(225,210,255,5);
					h5 = new Rectangle(280,400,260,5);
					h6 = new Rectangle(540,210,40,5);
					h7 = new Rectangle(480,160,230,5);
					h8 = new Rectangle(580,450,135,5);

					if(p.intersects(h1) ||p.intersects(h3) ||p.intersects(h4) ||p.intersects(h7))
					{
						if(vert > 0)
						{
							y += vert;
						}
						else{
							vert = 0;
						}

					}
					if(p.intersects(h2) ||p.intersects(h5) ||p.intersects(h6) ||p.intersects(h8))
					{
						if(vert < 0)
						{
							y += vert;
						}
						else{
							vert = 0;
						}

					}

					if(p.intersects(v1) ||p.intersects(v4) ||p.intersects(v6) ||p.intersects(v7))
					{
						if(hori > 0)
						{
							x += hori;
						}
						else{
							hori = 0;
						}
					}
					if(p.intersects(v2) ||p.intersects(v3) ||p.intersects(v5) ||p.intersects(v8))
					{
						if(hori < 0)
						{
							x+=hori;
						}
						else{
							hori = 0;
						}
					}

					x += hori;
					y += vert;

					if(p.intersects(e1)||p.intersects(e2)||p.intersects(e3)||p.intersects(e4)||p.intersects(e5))
					{
						System.out.println("ur stupid");
						fails++;
						x= 130;
						y = 250;
					}


					if(a >= 520)

						eSpeed = -3;

					if(a <=225)
						eSpeed = 3;

					if(h >= 520)
						eSpeed1 = -3;

					if(h <=225)
						eSpeed1 = 3;


					a += eSpeed;
					h += eSpeed1;
					//this is the code for delay
					try
					{
						t.sleep(10);
					}catch(InterruptedException e)
					{
					}

					repaint();
				}
			}
	}

	public void keyPressed(KeyEvent ke)
	{

		System.out.println(ke.getKeyCode()); //this will show you the code of different keys
		if(ke.getKeyCode()==39)//right arrow
			hori = speed;
		if(ke.getKeyCode()==37)//left arrow
			hori = -speed;
		if(ke.getKeyCode()==38)//down arrow
			vert = -speed;
		if(ke.getKeyCode()==40)//up arrow
			vert = speed;

	}
	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode()==39)//right arrow
			hori = 0;
		if(ke.getKeyCode()==37)//left arrow
			hori = 0;
		if(ke.getKeyCode()==38)//down arrow
			vert = 0;
		if(ke.getKeyCode()==40)//up arrow
			vert = 0;

	}
	public void keyTyped(KeyEvent ke)
	{
		//necessary to implement KeyListener
	}
	public static void main(String args[])
	{
		EndOfYearProjectStarterCode app=new EndOfYearProjectStarterCode();
	}

}