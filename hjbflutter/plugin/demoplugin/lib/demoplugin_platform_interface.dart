import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'demoplugin_method_channel.dart';

abstract class DemopluginPlatform extends PlatformInterface {
  /// Constructs a DemopluginPlatform.
  DemopluginPlatform() : super(token: _token);

  static final Object _token = Object();

  static DemopluginPlatform _instance = MethodChannelDemoplugin();

  /// The default instance of [DemopluginPlatform] to use.
  ///
  /// Defaults to [MethodChannelDemoplugin].
  static DemopluginPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [DemopluginPlatform] when
  /// they register themselves.
  static set instance(DemopluginPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
