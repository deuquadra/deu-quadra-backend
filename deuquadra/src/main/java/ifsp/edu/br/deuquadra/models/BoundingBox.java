package ifsp.edu.br.deuquadra.models;

public class BoundingBox {
    private double minLatitude;
    private double maxLatitude;
    private double minLongitude;
    private double maxLongitude;

    public BoundingBox(double latitude, double longitude, double radiusKm) {
        // terra em km
        final double R = 6371.0;

        double latRad = Math.toRadians(latitude);
        double lonRad = Math.toRadians(longitude);

        double radDist = radiusKm / R;

        double minLat = latRad - radDist;
        double maxLat = latRad + radDist;

        double deltaLon = Math.asin(Math.sin(radDist) / Math.cos(latRad));

        double minLon = lonRad - deltaLon;
        double maxLon = lonRad + deltaLon;

        this.minLatitude = Math.toDegrees(minLat);
        this.maxLatitude = Math.toDegrees(maxLat);
        this.minLongitude = Math.toDegrees(minLon);
        this.maxLongitude = Math.toDegrees(maxLon);
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public double getMaxLatitude() {
        return maxLatitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }



    public static void main(String[] args) {
        double latitude = 40.7128; // Example latitude (New York City)
        double longitude = -74.0060; // Example longitude (New York City)
        double radiusKm = 10.0; // Radius in kilometers

        BoundingBox bbox = new BoundingBox(latitude, longitude, radiusKm);
        System.out.println(bbox);
    }
}