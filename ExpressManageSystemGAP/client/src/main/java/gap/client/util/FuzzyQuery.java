package gap.client.util;

import java.util.ArrayList;

/**
 * 
 * 这是一个模糊查找的类，返回查找结果类(SearchResult)的list
 * @author 申彬
 *
 */
public class FuzzyQuery {
	/**
	 * 模糊查找的算法：(根据eclipse自动补全推测出来的)<p/>
	 * 第一个位置有一个基础权值100，第二个位置99，第三个位置98，以此类推。<br/>
	 * 从keyword的第一个字符开始，从头开始遍历一个字符串，每找到一个对应字符，<br/>
	 * 检查 连续匹配的boolean是否为true，是则加200，若不是，将其基础权值加到累加器<br/>
	 * 	，并且设置连续位为true，keyword的index++，接着找。<p/>
	 * 该算法会将连续出现keyword中连续字符的串排在前边，假如连续情况相同，追加一个判断，短的排前边<br>
	 * @param source
	 * @param keyword
	 * @return
	 */
	public ArrayList<SearchResult> fuzzyQuery(String[] source,String keyword)
	{
		
		return null;
	}
}
