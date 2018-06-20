#!/usr/bin/env bash
ln -s "`pwd`/stargate.dev.local.conf" /etc/nginx/sites-enabled/
ln -s "`pwd`/stargate-base.dev.local.conf" /etc/nginx/sites-enabled/
cat >> /etc/hosts <<EOF
127.0.0.1 stargate.dev.local
127.0.0.1 stargate-base.dev.local
EOF
systemctl restart nginx