### CurveView
An Android library for creating a Curve Like in screenshots.
 
![Curve at Top](/screenshot/curve_top.png)       ![Curve at Bottom](/screenshot/curve_bottom.png)



## Custom Attr
 * There are four attributes for customizing View.
  `border_color` , `border_width` , `curve_color` and `curve_gravity`

  Usage of these attribute given below.

## Usage
 ```xml
  <com.codefromlab.curveview.CurveView
              android:layout_width="match_parent"
              android:layout_height="40dp"
              // To set border color
              app:border_color="#48b35b"
              // To set border width
              app:border_width="2dp"
              // Color of Curve
              app:curve_color="#FFFFFF"
              // curve position
              app:curve_gravity="top"
              />
 ```
