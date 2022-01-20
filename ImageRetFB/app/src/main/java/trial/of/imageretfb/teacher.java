package trial.of.imageretfb;

public class teacher {

    private String name;
    private String imageURL;
    private String key;
    private String description;
    private int position;

    public teacher (){

    }

    public  teacher (int position){
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public  teacher (String name, String imageURL, String Des){

        if(name.trim().equals("")){
            name = "No Name";
        }
        this.name = name;
        this.imageURL= imageURL;
        this.description=Des;
    }

}
