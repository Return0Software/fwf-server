package com.github.return0software.fwf.health;

import com.codahale.metrics.health.HealthCheck;

public final class DefaultHealthCheck extends HealthCheck {
	@Override
	protected Result check() {
		return Result.healthy();
	}
}
