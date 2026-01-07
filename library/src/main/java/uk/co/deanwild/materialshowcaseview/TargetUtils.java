package uk.co.deanwild.materialshowcaseview;

import android.graphics.RectF;
import android.view.View;

final class TargetUtils {

    private TargetUtils() {
    }

    static RectF computeTargetRectRelativeToOverlay(View target, View overlayRoot) {
        if (target == null || overlayRoot == null) {
            return null;
        }

        int width = target.getWidth();
        int height = target.getHeight();
        if (width == 0 || height == 0) {
            width = target.getMeasuredWidth();
            height = target.getMeasuredHeight();
        }
        if (width == 0 || height == 0) {
            return null;
        }

        int[] targetLocation = new int[2];
        target.getLocationOnScreen(targetLocation);

        int[] overlayLocation = new int[2];
        overlayRoot.getLocationOnScreen(overlayLocation);

        // Align screen coordinates to the overlay's coordinate space (fixes edge-to-edge offsets).
        float left = targetLocation[0] - overlayLocation[0];
        float top = targetLocation[1] - overlayLocation[1];
        return new RectF(left, top, left + width, top + height);
    }
}
