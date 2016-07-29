import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class WeekOfTheMonth extends UDF
{
	public int evaluate(Text text)
	{
		String str = text.toString();
		try
		{
			if(!str.equalsIgnoreCase("") && str != null)
			{			
				String arr[] = str.split(" ")[0].split("-"); 
				Calendar cal1 = GregorianCalendar.getInstance();
				cal1.set(Calendar.YEAR, Integer.parseInt(arr[0]));
				cal1.set(Calendar.MONTH, Integer.parseInt(arr[1])-1);
				cal1.set(Calendar.DAY_OF_MONTH, Integer.parseInt(arr[2]));
				
				int res = cal1.get(Calendar.WEEK_OF_MONTH);			
				return res;
			}
		}		
		catch(Exception e)
		{
			return 0;
		}		
		return 0;
	}
}
