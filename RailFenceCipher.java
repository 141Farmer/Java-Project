import java.util.Arrays;

public class RailFenceCipher 
{
    private int rails;
    public RailFenceCipher(int rails) 
    {
        this.rails=rails;
    }
    public String encode(String plaintext)
    {
        char[][] matrix=new char[rails][plaintext.length()];
        for (int i=0;i<rails;++i)
        {
            Arrays.fill(matrix[i], '\n');
        }
        boolean dir=false;
        int row=0,col=0;
        for(int i=0;i<plaintext.length();++i) 
        {
            if(row==0||row==rails-1)
                dir=!dir;
            matrix[row][col++]=plaintext.charAt(i);
            if (dir)
                ++row;
            else
                --row;
        }
        StringBuilder ciphertext=new StringBuilder();
        for(int i=0;i<rails;++i)
        {
            for(int j=0;j<plaintext.length();++j)
            {
                if(matrix[i][j]!='\n')
                    ciphertext.append(matrix[i][j]);
            }
        }
        return ciphertext.toString();
    }

    public String decode(String ciphertext)
    {
        char[][] matrix=new char[rails][ciphertext.length()];
        for (int i=0;i<rails;++i)
        {
            Arrays.fill(matrix[i], '\n');
        }
        boolean dir=true;
        int row=0,col=0;
        for(int i=0;i<ciphertext.length();++i) 
        {
            if(row==0)
                dir=true;
            if(row==rails-1)
                dir=false;
            matrix[row][col++]='$';
            if(dir)
                ++row;
            else
                --row;
        }
        int index=0;
        for(int i=0;i<rails;++i)
        {
            for(int j=0;j<ciphertext.length();++j)
            {
                if(matrix[i][j]=='$'&&index<ciphertext.length())
                    matrix[i][j]=ciphertext.charAt(index++);
            }
        }
        StringBuilder plaintext=new StringBuilder();
        row=0;
        col=0;
        for(int i=0;i<ciphertext.length();++i) 
        {
            if(row==0)
                dir=true;
            if(row==rails-1)
                dir=false;
            if(matrix[row][col]!='$')
                plaintext.append(matrix[row][col++]);
            if(dir)
                ++row;
            else
                --row;
        }
        return plaintext.toString();
    }
}
