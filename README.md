

# cordova-plugin-scanManualInput
	带有手动输入按钮的扫描插件
## Installation

	cordova plugin add https://github.com/Edc-zhang/cordova-plugin-scanManualInput.git

## UnInstall
	cordova plugin rm cordova-plugin-scanManualInput

### Supported Platforms

- Android
- iOS




### Quick Example

	//扫描，参数scanText扫描框下面的一段提示语，字符串类型
	scan.recognize("scanText",function (message) {
        alert(message);
      }, function (message) {

      });
