import 'package:flutter_test/flutter_test.dart';
import 'package:demoplugin/demoplugin.dart';
import 'package:demoplugin/demoplugin_platform_interface.dart';
import 'package:demoplugin/demoplugin_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class MockDemopluginPlatform
    with MockPlatformInterfaceMixin
    implements DemopluginPlatform {

  @override
  Future<String?> getPlatformVersion() => Future.value('42');
}

void main() {
  final DemopluginPlatform initialPlatform = DemopluginPlatform.instance;

  test('$MethodChannelDemoplugin is the default instance', () {
    expect(initialPlatform, isInstanceOf<MethodChannelDemoplugin>());
  });

  test('getPlatformVersion', () async {
    Demoplugin demopluginPlugin = Demoplugin();
    MockDemopluginPlatform fakePlatform = MockDemopluginPlatform();
    DemopluginPlatform.instance = fakePlatform;

    expect(await demopluginPlugin.getPlatformVersion(), '42');
  });
}
