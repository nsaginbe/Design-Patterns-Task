package adapter;

public class DeliveryService {
    private String destinationAddress;

    public void deliver(PackedMeal packedMeal) {
        System.out.println("Successfully delivered to address " + getDestinationAddress() +
                " at time " + TimeConverter.getTime());

        System.out.println("Delivery info:\n" + packedMeal);

    }

    public String getDestinationAddress() {
        return destinationAddress;
    }
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }
}
