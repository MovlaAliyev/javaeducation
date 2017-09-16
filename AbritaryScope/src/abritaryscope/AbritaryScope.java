/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abritaryscope;

/**
 *
 * @author Javatarr
 */
public class AbritaryScope {

    private void internalTrack(boolean b) {
        if (b) {
            class TrackingSlip {

                private String s;

                public TrackingSlip(String s) {
                    this.s = s;
                }

                String getSlip() {
                    return s;
                }
            }
            TrackingSlip slip = new TrackingSlip("s");
            String s = slip.getSlip();
        }

    }

    public void track() {
        internalTrack(false);
    }

    public static void main(String[] args) {
        AbritaryScope as = new AbritaryScope();
        as.track();
    }

}
