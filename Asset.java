
public class Asset
{
private String assetDescription;
private double assetValue;
    
    public Asset(String newAssetDescription, double newAssetValue)
    {
        assetDescription = newAssetDescription;
        assetValue = newAssetValue;
    }
    public String getDescription()
    {
	return assetDescription;
    }
	
    public double getAssetValue()
    {
	return assetValue;
    }
	
    public void setDescription(String newAssetDescription)
    {
	assetDescription = newAssetDescription;
    }
	
    public void setAssetAmount(double newAssetValue)
    {
	assetValue = newAssetValue;
    }
}
