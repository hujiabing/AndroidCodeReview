import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'demoplugin_platform_interface.dart';

/// An implementation of [DemopluginPlatform] that uses method channels.
class MethodChannelDemoplugin extends DemopluginPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('demoplugin');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
