public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
}

public class Tv implements Device {
    private boolean on = false;
    private int volume = 50;
    private int channel = 1;

    public boolean isEnabled() {
        return on;
    }
    public void enable() {
        on = true;
        System.out.println("TV is now ON");
    }
    public void disable() {
        on = false;
        System.out.println("TV is now OFF");
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("TV volume set to " + volume);
    }
    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("TV channel set to " + channel);
    }
}

public class Radio implements Device {
    private boolean on = false;
    private int volume = 50;
    private int channel = 1;

    public boolean isEnabled() {
        return on;
    }
    public void enable() {
        on = true;
        System.out.println("Radio is now ON");
    }
    public void disable() {
        on = false;
        System.out.println("Radio is now OFF");
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("Radio volume set to " + volume);
    }
    public int getChannel() {
        return channel;
    }
    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println("Radio channel set to " + channel);
    }
}

public class Remote {
    protected Device device;

    public Remote(Device device) {
        this.device = device;
    }
    public void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }
    public void volumeDown() {
        device.setVolume(device.getVolume() - 10);
    }
    public void volumeUp() {
        device.setVolume(device.getVolume() + 10);
    }
    public void channelDown() {
        device.setChannel(device.getChannel() - 1);
    }
    public void channelUp() {
        device.setChannel(device.getChannel() + 1);
    }
}

public class AdvancedRemote extends Remote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
    }
}


public class Application1 {
    public static void main(String[] args) {
        Device tv = new Tv();
        Remote remote = new Remote(tv);
        remote.togglePower();
        remote.volumeUp();
        remote.channelUp();

        Device radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.togglePower(); 
        advancedRemote.mute();
    }
}
