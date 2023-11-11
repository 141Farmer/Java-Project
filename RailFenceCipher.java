public class RailFenceCipher implements Cryption
{
    private int rails;

    public RailFenceCipher(int rails) 
	{
        this.rails=rails;
    }

    public String encode(String plainText) 
	{
        int row=rails,len=plainText.length();
        int col=len/rails;
        char mat[][]=new char[row][col];
        int index=0;
        for(int i=0;i<col;++i) 
		{
            for(int j=0;j<row;++j) 
			{
                if(index!=len)
                    mat[j][i]=plainText.charAt(index++);
                else
                    mat[j][i]='X';
            }
        }
		StringBuilder cipherText=new StringBuilder();
        for(int i=0;i<row;++i) 
		{
            for(int j=0;j<col;++j) 
			{
                cipherText.append(mat[i][j]);
            }
        }
        return cipherText.toString();
    }

    public String decode(String cipherText)  
	{
        int row=rails,len=cipherText.length();
        int col=len/rails;
        char mat[][]=new char[row][col];
        int index=0;
        StringBuilder plainText=new StringBuilder();
        for(int i=0;i<row;++i) 
		{
            for(int j=0;j<col;++j) 
			{
                mat[i][j]=cipherText.charAt(index++);
            }
        }
        for(int i=0;i<col;++i) 
		{
            for(int j=0;j<row;++j) 
			{
                plainText.append(mat[j][i]);
            }
        }
        return plainText.toString();
    }
}
