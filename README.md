
When we stop a container, we send a `SIGTERM` to the PID 1 of the container.

The goal of the small project is to document how to manage this signal in Scala to
avoid crash or broken state on Ignite, PostgreSQL and S3.
