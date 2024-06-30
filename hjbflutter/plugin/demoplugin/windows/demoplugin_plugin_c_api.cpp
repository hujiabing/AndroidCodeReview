#include "include/demoplugin/demoplugin_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "demoplugin_plugin.h"

void DemopluginPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  demoplugin::DemopluginPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
