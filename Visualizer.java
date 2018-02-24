import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Visualizer extends JFrame implements KeyListener, MouseListener {
	private static final long serialVersionUID = -6754436015453195809L;

	private BufferedImage frame;

	static final private int ZOOM_LIMIT = 16;
	private int zoom = 4;
	private int lastX = -1;
	private int lastY = -1;

	public void setFrame(BufferedImage f) {
		frame = f;
		repaint();
	}

	public Visualizer() {
		super();
		this.frame = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 4370983408153076632L;

			@Override
			protected void paintComponent(Graphics graphics) {
				super.paintComponent(graphics);

				Graphics2D g2 = (Graphics2D) graphics;
				AffineTransform at = new AffineTransform();
				at.scale(zoom, zoom);
				g2.transform(at);

				g2.drawImage(frame, 0, 0, null);

				AffineTransform at2 = new AffineTransform();
				at2.translate(0.5, 0.5);
				g2.transform(at2);
				// graphics.drawRect(lastX / zoom, lastY / zoom, 0, 0);
				g2.drawLine(lastX / zoom, lastY / zoom, lastX / zoom, lastY / zoom);

				setPreferredSize(new Dimension(frame.getWidth() * zoom, frame.getHeight() * zoom));
				getParent().revalidate();
			}
		};
		JScrollPane sp = new JScrollPane(panel);
		sp.setBorder(BorderFactory.createEmptyBorder());
		add(sp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
		panel.addMouseListener(this);
		setLocation(200, 100);
		setSize(800, 600);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == ']') {
			if (zoom < ZOOM_LIMIT) {
				zoom++;
			}
		} else if (e.getKeyChar() == '[') {
			if (zoom > 1) {
				zoom--;
			}
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
