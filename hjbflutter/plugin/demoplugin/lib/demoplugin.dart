
import 'demoplugin_platform_interface.dart';

class Demoplugin {
  Future<String?> getPlatformVersion() {
    return DemopluginPlatform.instance.getPlatformVersion();
  }
}
