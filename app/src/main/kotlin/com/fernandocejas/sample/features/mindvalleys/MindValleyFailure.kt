package com.fernandocejas.sample.features.mindvalleys

import com.fernandocejas.sample.core.exception.Failure

class MindValleyFailure {
    class ListNotAvailable: Failure.FeatureFailure()
    class NonExistentCategory: Failure.FeatureFailure()
}