import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,600,20);  
        jb[0].setBounds(50,80,600,20);  
        jb[1].setBounds(50,110,600,20);  
        jb[2].setBounds(50,140,600,20);  
        jb[3].setBounds(50,170,600,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(900,550);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,30+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: What file is read by ODBC to load drivers ?");  
            jb[0].setText("ODBC.INI");jb[1].setText("ODBCDRV.INI");jb[2].setText("ODBC.DLL");jb[3].setText("None of the above");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Explicitly we can assign transaction to a rollback segment");  
            jb[0].setText("True");jb[1].setText("False"); 
        }  
        if(current==2)  
        {  
            l.setText("Que3: The status of the Rollback segment can be viewed through ?");  
            jb[0].setText("DBA_SEGMENTS");jb[1].setText("DBA_ROLES");jb[2].setText("DBA_ROLLBACK_SEG");jb[3].setText("DBA_FREE_SPACES");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: It is very difficult to grant and manage common privileges needed by different groups of database users using roles.");  
            jb[0].setText("True");jb[1].setText("False");
        }  
        if(current==4)  
        {  
            l.setText("Que5: What is the appropriate destination type to send the output to a printer ?");  
            jb[0].setText("Screen");jb[1].setText("Previewer");jb[2].setText("Either of the above");jb[3].setText("None of the above");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Kind of COMMENT statements placed within SQL statements ?");  
            jb[0].setText("Asterisk(*) in column ?");jb[1].setText("ANSI SQL style statements(?)");jb[2].setText("C-Style comments (/*??*/)");jb[3].setText("All the above");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: What is an ALERT ? ");  
            jb[0].setText("Modeless window");jb[1].setText("Modal window");jb[2].setText("Both are TRUE");  
                        jb[3].setText("None of the above");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Choose two SGA structures that are required in every Oracle instance.");  
            jb[0].setText("Large pool");jb[1].setText("Shared pool");jb[2].setText("Buffer cache");  
                        jb[3].setText("Java pool");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: In the physical implementation of RDBMS, which database object is used to represent unique identifiers?");  
            jb[0].setText("Any constraint");jb[1].setText("Index");jb[2].setText("Primary key");jb[3].setText("Foreign key");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: SQL Developer is a tool primarily for whom?");  
            jb[0].setText("Database administrators");jb[1].setText("End users");jb[2].setText("Application developers");  
                        jb[3].setText("All of the above");  
        }  
        l.setBounds(30,40,8050,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[3].isSelected());  
        if(current==5)  
            return(jb[3].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[1&2].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of SQL");  
    }  
}  