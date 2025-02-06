package com.rubixdev.carpet.addon;

import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.Validator;
import net.minecraft.server.command.ServerCommandSource;

import static carpet.settings.RuleCategory.*;

public class CarpetAddonSettings {
    public static final String CUSTOM = "custom";  // Custom Category

    public static class validatorExampleRule extends Validator<Integer> {

        @Override
        public Integer validate(ServerCommandSource serverCommandSource, ParsedRule<Integer> parsedRule, Integer newValue, String s) {
            return newValue >= 0 && newValue <= 32 ? newValue : null;
        }

        @Override
        public String description() {
            return "You must choose a value from 0 to 32";
        }
    }

    // strict = true only allows given options, false allows other inputs
    // validate = validator class, only needed when strict = false
    @Rule(
            desc = "Example description for example Rule",
            options = {"0", "2", "5", "10"},
            category = {CREATIVE, EXPERIMENTAL, FEATURE, CUSTOM},
            strict = false,
            validate = validatorExampleRule.class
    )
    public static int exampleRule = 0;  // Name and default value of Rule, please make default value keep vanillas default
    // exampleRuleAdditional: Additional info the Python parser will include in the READMEs. You can use markdown here
}

// All default categories (I think):
// BUGFIX
// COMMAND
// EXPERIMENTAL
// FEATURE
// CREATIVE
// CLIENT
// DISPENSER
// OPTIMIZATION
// SCARPET
// SURVIVAL
// TNT
