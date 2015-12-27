package gap.client.ui.expressorderquery;

import gap.client.ui.UITools.RenderSetter;
import gap.client.ui.expressorderquery.components.QueryArc;
import gap.client.ui.expressorderquery.components.StringInfo;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * 查询结果的显示
 * @author YangYanfei
 *
 */
class ResultShowPanel extends JPanel {
	QueryArc q;
	StringInfo info;

	public ResultShowPanel() {
		setLayout(null);
		q = new QueryArc(200, 200, 1, this);
		info = new StringInfo("快件已经到达南京中转中dwad心", q.getEndPoint(), 1);
		// add(info);
		info.reLocat();

	}

	public void chang() {
		q.change();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = RenderSetter.OpenRender(g);
		q.draw(g2d);
		info.draw(g2d);
	}
}
