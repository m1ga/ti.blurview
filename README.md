# Ti.Blurview
## Android BlurView module for Appcelerator Titanium

<span class="badge-patreon"><a href="https://www.patreon.com/michaelgangolf" title="Donate to this project using Patreon"><img src="https://img.shields.io/badge/patreon-donate-yellow.svg" alt="Patreon donate button" /></a></span>

<img src="screen.gif"/><br/>

Simple Android BlurView module for Appcelerator Titanium. Based on: https://github.com/mmin18/RealtimeBlurView

### Usage

```xml
<modules>
  <module platform="android">ti.blurview</module>
</modules>
```

```xml
<BlurView module="ti.blurview"/>
```
or
```javascript
var blur = require("ti.blurview");
var blurView = blur.createBlurView({});
```

### API

<b>Properties:</b>
* blurRadius (int)
* backgroundColor (color)

### Example:

```javascript
var win = Ti.UI.createWindow({
	backgroundColor: "#fff"
});
var img = Ti.UI.createImageView({
	image: "https://raw.githubusercontent.com/CameraKit/blurkit-android/master/demo/src/main/res/drawable-nodpi/peppers.png",
	width: 640,
	height: 400,
	top: 0
})
var blurview = require("ti.blurview").createBlurView({
	blurRadius: 20,
    backgroundColor: "#88000000",
	width: Ti.UI.FILL,
	height: 100,
	top: 100
});
var view_menu = Ti.UI.createView({
	bottom: 0,
	height: Ti.UI.SIZE,
	width: Ti.UI.FILL,
	layout: "vertical",
	backgroundColor: "#efefef"
})
win.add([img, blurview, view_menu]);

var lbl1 = Ti.UI.createLabel({
	text: "Blur: 2",
	color: "#000",
	left: 10,
	top: 10
});
var slider1 = Ti.UI.createSlider({
	min: 1,
	max: 20,
	left: 20,
	right: 20,
	value: 20,
	bottom: 10
})
view_menu.add([lbl1, slider1]);

slider1.addEventListener("change", function(e) {
	blurview.blurRadius = Math.round(e.value);
	lbl1.text = "Blur: " + Math.round(e.value);
});

var btn1 = Ti.UI.createButton({
	title: "move"
})

view_menu.add([btn1, btn2]);

btn1.addEventListener("click", function(e) {
	blurview.animate({
		top: 400,
		duration: 4000,
		autoreverse: true
	})
});

win.open();
```
