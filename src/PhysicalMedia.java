import java.io.Serializable;

public class PhysicalMedia implements Serializable {
    private DiskType diskType;

    private String mediaName;

    private int releaseDate;
    private String director;
    private int rottenTomatoesRating;

    public PhysicalMedia(DiskType diskType, String mediaName,String director, int releaseDate, int rottenTomatoesRating) {
        this.diskType = diskType;
        this.mediaName = mediaName;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rottenTomatoesRating = rottenTomatoesRating;
    }




    enum DiskType {
        BLUERAY,
        DVD,
        CD
    }
    //getter

    public DiskType getdiskType() {
        return diskType;
    }

    public String getMediaName() {
        return mediaName;
   }

   public int getReleaseDate() {
        return releaseDate;
   }

   public String getDirector() {
        return director;
   }

   public int getRottenTomatoesRating() {
        return rottenTomatoesRating;
   }


   //setters

    public void setDiskType(DiskType diskType){
        this.diskType = diskType;
    }
    public void setMediaName(String mediaName){
        this.mediaName = mediaName;
    }
    public void setReleaseDate(int releaseDate){
        this.releaseDate = releaseDate;
    }
    public void setDirector(String director){
        this.director = director;
    }
    public void setRottenTomatoesRating(int rottenTomatoesRating){
        this.rottenTomatoesRating = rottenTomatoesRating;
    }

 

    }

