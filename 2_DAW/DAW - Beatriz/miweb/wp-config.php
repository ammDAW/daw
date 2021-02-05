<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the
 * installation. You don't have to use the web site, you can
 * copy this file to "wp-config.php" and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * MySQL settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://wordpress.org/support/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** MySQL settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'miweb_wordpress' );

/** MySQL database username */
define( 'DB_USER', 'root' );

/** MySQL database password */
define( 'DB_PASSWORD', '' );

/** MySQL hostname */
define( 'DB_HOST', 'localhost' );

/** Database Charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The Database Collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication Unique Keys and Salts.
 *
 * Change these to different unique phrases!
 * You can generate these using the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}
 * You can change these at any point in time to invalidate all existing cookies. This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         'YZbao o0Gx}%z*pV=Z#J5WVqnAs$De{|cC&og[m`?fr}%p5}XyyB#5Qci5%;jRgv' );
define( 'SECURE_AUTH_KEY',  'L;NH9#f:j|Hi{RW]:HbWB:Guv=#omso>)nOP&;Qq9k_Ka }JD-6yBW6;W{tggt:7' );
define( 'LOGGED_IN_KEY',    ',i+_BW {T-e|rNMDefL@ziD:1,?D1(R`0h0F]S:g7v&V0x|`jw^kHYtNv8$fn7Di' );
define( 'NONCE_KEY',        '+K>aYPm!o&WHb^TDA%S901A8/K$o%D:]mfElR_kNr=A~li?5abV:%=?eR.LN:.Q=' );
define( 'AUTH_SALT',        'L2P.xc{el/$*11+}-{[Vx*MC,r,qb^HnKVsu1V| WUGi[mJdp>Ns4F*z(z)o-(v#' );
define( 'SECURE_AUTH_SALT', '4pk14bzcvje#?w?[d]}%lv*Tw97X!e>,^i6mQB62:a#zc9;9N!z)d]fu~`k.S%.*' );
define( 'LOGGED_IN_SALT',   '*ID!8,wu@R+f%/Dk$@[>x/lD$_]S1<+`tJ^`BLEX#WzO~+@<Hf^%])Igrn9`z#e/' );
define( 'NONCE_SALT',       'Z7gDgO,vl&%QYVhyr<Xc=?[js>zmP?L?rA{B5|oxcw/z3nwV/C-#V*rS)QdZ5K1i' );

/**#@-*/

/**
 * WordPress Database Table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://wordpress.org/support/article/debugging-in-wordpress/
 */
define( 'WP_DEBUG', false );

/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';
