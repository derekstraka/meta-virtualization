DESCRIPTION = "Trivial sqlite3 binding for Go"
HOMEPAGE = "https://code.google.com/p/gosqlite"
SECTION = "devel/go"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRCNAME = "gosqlite"

PKG_NAME = "code.google.com/p/${SRCNAME}"
SRC_URI = "hg://code.google.com/p;module=gosqlite"

SRCREV = "74691fb6f83716190870cde1b658538dd4b18eb0"

SRC_URI[md5sum] = "04bb4682d0113d5dbcd4a1dbf6b24dfc"
SRC_URI[sha256sum] = "478967fee730b85a6a4f96ace1e08fe91b6dfa6d641856bcd4574baec2f0361c"

S = "${WORKDIR}/${SRCNAME}"

do_install() {
	install -d ${D}${prefix}/local/go/src/${PKG_NAME}
	cp -r ${S}/* ${D}${prefix}/local/go/src/${PKG_NAME}/
}

SYSROOT_PREPROCESS_FUNCS += "go_gosqlite_sysroot_preprocess"

go_gosqlite_sysroot_preprocess () {
    install -d ${SYSROOT_DESTDIR}${prefix}/local/go/src/${PKG_NAME}
    cp -r ${D}${prefix}/local/go/src/${PKG_NAME} ${SYSROOT_DESTDIR}${prefix}/local/go/src/$(dirname ${PKG_NAME})
}

FILES_${PN} += "${prefix}/local/go/src/${PKG_NAME}/*"
