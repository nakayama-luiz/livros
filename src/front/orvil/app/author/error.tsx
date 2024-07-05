"use client";

import { edgeServerPages } from "next/dist/build/webpack/plugins/pages-manifest-plugin";
import { useEffect } from "react";

export default function Error({
  error,
  reset,
}: {
  error: Error;
  reset: () => void;
}) {
  useEffect(() => {
    // Log the error to an error reporting service
    /* eslint-disable no-console */
    console.error(error);
  }, [error]);

  return (
    <div>
      <h2>Melhoras, amigo</h2>
      {error.message}
    </div>
  );
}
