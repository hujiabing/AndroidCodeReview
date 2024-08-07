#ifndef FLUTTER_PLUGIN_DEMOPLUGIN_PLUGIN_H_
#define FLUTTER_PLUGIN_DEMOPLUGIN_PLUGIN_H_

#include <flutter/method_channel.h>
#include <flutter/plugin_registrar_windows.h>

#include <memory>

namespace demoplugin {

class DemopluginPlugin : public flutter::Plugin {
 public:
  static void RegisterWithRegistrar(flutter::PluginRegistrarWindows *registrar);

  DemopluginPlugin();

  virtual ~DemopluginPlugin();

  // Disallow copy and assign.
  DemopluginPlugin(const DemopluginPlugin&) = delete;
  DemopluginPlugin& operator=(const DemopluginPlugin&) = delete;

 private:
  // Called when a method is called on this plugin's channel from Dart.
  void HandleMethodCall(
      const flutter::MethodCall<flutter::EncodableValue> &method_call,
      std::unique_ptr<flutter::MethodResult<flutter::EncodableValue>> result);
};

}  // namespace demoplugin

#endif  // FLUTTER_PLUGIN_DEMOPLUGIN_PLUGIN_H_
