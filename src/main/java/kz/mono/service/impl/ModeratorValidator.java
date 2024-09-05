package kz.mono.service.impl;

import kz.mono.service.IModeratorValidator;

import java.util.List;

public class ModeratorValidator implements IModeratorValidator {
    private final List<Long> moderatorIds;

    public ModeratorValidator(List<Long> moderatorIds) {
        this.moderatorIds = moderatorIds;
    }

    @Override
    public boolean isModerator(long userId) {
        return moderatorIds.contains(userId);
    }
}
