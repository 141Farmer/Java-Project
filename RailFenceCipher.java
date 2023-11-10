import java.util.Arrays;
public class RailFenceCipher 
{
    private int key;
    public RailFenceCipher(int key)
    {
        this.key=key;
    }
	public String encode(String text)
	{
		char[][] rail=new char[key][text.length()];
		for (int i=0;i<key;++i)
        {
            Arrays.fill(rail[i],'\n');
        }
		boolean upDown=false;
		int row=0,col=0;
		for(int i=0;i<text.length();++i) 
        {
			if(row==0 || row==key-1)
				upDown=!upDown;
			rail[row][col++]=text.charAt(i);
			if (upDown)
				++row;
			else
				--row;
		}
		StringBuilder result=new StringBuilder();
		for(int i=0;i<key;++i)
        {
            for (int j=0;j<text.length();++j)
            {
                if(rail[i][j]!='\n')
                {
                    result.append(rail[i][j]);
                }
            }
        }
		return result.toString();
	}
	public String decode(String cipher)
	{
		char[][] rail=new char[key][cipher.length()];

		for (int i=0;i<key;++i)
        {
            Arrays.fill(rail[i], '\n');
        }
		boolean upDown=true;
		int row=0,col=0;
		for(int i=0;i<cipher.length();++i) 
        {
			if(row==0)
				upDown=true;
			if(row==key-1)
				upDown=false;
			rail[row][col++]='$';
			if (upDown)
				++row;
			else
				--row;
		}

		int index=0;
		for(int i=0;i<key;++i)
        {
            for(int j=0;j<cipher.length();++j)
            {
                if(rail[i][j]=='$'  &&  index<cipher.length())
					rail[i][j]=cipher.charAt(index++);
            }
        }
		StringBuilder result=new StringBuilder();
		row=0;
		col=0;
		for(int i=0;i<cipher.length();++i) 
        {
			if(row==0)
				upDown=true;
			if(row==key-1)
				upDown=false;
			if(rail[row][col]!='$')
				result.append(rail[row][col++]);
			if(upDown)
				++row;
			else
				--row;
		}
		return result.toString();
	}
}