# MeteorVisuals V2

MeteorVisuals is a Fabric client-side visual enhancement mod for Minecraft 1.21.4.

Important principle: this project does not change gameplay, server simulation, hitboxes, damage, movement, or combat logic. All features are client-side rendering, HUD overlays, cosmetic effects, and interface customization only.

## Structure

- `module/` contains the core module system: `Module`, `Category`, and `ModuleManager`.
- `setting/` contains value-based settings such as toggles, sliders, colors, and mode lists.
- `gui/` contains the ClickGUI and theme utilities.
- `modules/hud/` contains example modules such as `Watermark`.
- `effects/` contains `EffectPreset` and the preset manager used by the visual effect editor.
- `config/` contains JSON-based config loaders for saving module state.

## No Gameplay Changes

This mod intentionally does not touch server logic, entity behavior, combat rules, or movement. Any feature that modifies the world is limited to local rendering or HUD display.

## Runtime notes

- The mod is a client-only mod (`environment: client`).
- Configuration is stored under the Fabric config directory: `.minecraft/config/meteorvisuals`.
- A placeholder icon is included at `src/main/resources/assets/meteorvisuals/icon.png`.
