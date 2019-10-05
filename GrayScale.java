
/**
 * Write a description of GrayScale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class GrayScale {
public ImageResource makeGray(ImageResource inImage)
{
    ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
    for(Pixel pixel:outImage.pixels())
    {
        Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
        int average=(inPixel.getRed()+inPixel.getGreen()+inPixel.getBlue())/3;
        pixel.setRed(average);
        pixel.setGreen(average);
        pixel.setBlue(average);
    }
    return outImage;
}
public ImageResource makeInverted(ImageResource inImage)
{
    ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());
    for(Pixel pixel:outImage.pixels())
    {
        Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());
        pixel.setRed(255-inPixel.getRed());
        pixel.setGreen(255-inPixel.getGreen());
        pixel.setBlue(255-inPixel.getBlue());
    }
    return outImage;
}
public void selectAndConvert()
{
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())
    {
        ImageResource ir=new ImageResource(f);
        ImageResource gray=makeGray(ir);
        gray.draw();
    }
}
public void testSaveImage()
{
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())
    {
        ImageResource image=new ImageResource(f);
        String fname=image.getFileName();
        String newName="gray-"+fname;
        ImageResource ir=makeGray(image);
        ir.setFileName(newName);
        ir.draw();
        ir.save();
    }
}
public void invertAndSaveImage()
{
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles())
    {
        ImageResource image=new ImageResource(f);
        String fname=image.getFileName();
        String newName="Inverted-"+fname;
        ImageResource ir=makeInverted(image);
        ir.setFileName(newName);
        ir.draw();
        ir.save();
    }
}
}
