package veilingActions.visitor;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;

import org.apache.struts2.interceptor.ServletRequestAware;

import veilingDomain.Aanbieding;
import veilingService.VeilingService;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {

	private Aanbieding aanbieding;
	byte[] imageInByte = null;
	String imageId;
	
	private HttpServletRequest servletRequest;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public ImageAction() {
		System.out.println("ImageAction");
	}

	public String execute() {
		int aanbiedingNr = Integer.parseInt(imageId);
		aanbieding = VeilingService.getAanbieding(aanbiedingNr);
		return SUCCESS;
	}

	public byte[] getImage() {
		BufferedImage originalImage;
		try {
			if (aanbieding.getImg() != null) {
				originalImage = ImageIO.read(new ByteArrayInputStream(
						aanbieding.getImg()));
				// convert BufferedImage to byte array
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(originalImage, "png", baos);
				baos.flush();
				imageInByte = baos.toByteArray();
				baos.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageInByte;
	}

	private File getImageFile(String imageId) {
		String filePath = servletRequest.getSession().getServletContext()
				.getRealPath("/");
		File file = new File(filePath + "/images/", imageId);
		System.out.println(file.toString());
		return file;
	}

	public String getCustomContentType() {
		return "image/jpeg";
	}

	public String getCustomContentDisposition() {
		return "anyname.jpg";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}
	
}