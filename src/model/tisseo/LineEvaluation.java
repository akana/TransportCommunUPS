package model.tisseo;

public class LineEvaluation {
    private String _id;
    private String _rev;
    
    private String lineNumber;
    private int numLike;
    private int numUnlike;
    

    public LineEvaluation(String _id, String _rev, String lineNumber,
            int numLike, int numUnlike) {
        this._id = _id;
        this._rev = _rev;
        this.lineNumber = lineNumber;
        this.numLike = numLike;
        this.numUnlike = numUnlike;
    }
    
    public String getLineNumber() {
        return lineNumber;
    }
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }
    public int getNumLike() {
        return numLike;
    }
    public void setNumLike(int numLike) {
        this.numLike = numLike;
    }
    public int getNumUnlike() {
        return numUnlike;
    }
    public void setNumUnlike(int numUnlike) {
        this.numUnlike = numUnlike;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String _rev) {
        this._rev = _rev;
    }
    
}
